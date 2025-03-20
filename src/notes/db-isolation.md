# Database Isolation Levels with SQL Examples

Database isolation levels define the degree to which transactions are separated from each other in a concurrent database environment. The SQL standard defines four isolation levels:

1. **Read Uncommitted**
2. **Read Committed**
3. **Repeatable Read**
4. **Serializable**

Each level provides a different balance between performance and data consistency.

---
Setup
```sql
CREATE TABLE accounts (
    id INT PRIMARY KEY,
    balance DECIMAL(10, 2)
);

INSERT INTO accounts (id, balance) VALUES (1, 100.00);
```

## 1. Read Uncommitted

- Transactions can read uncommitted changes made by other transactions.
- Can lead to **dirty reads**, **non-repeatable reads**, and **phantom reads**.

### Example:
#### Session 1:
```sql
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
BEGIN TRANSACTION;
UPDATE accounts SET balance = 150.00 WHERE id = 1;
-- Transaction 1 does not commit yet
```
#### Session 2:
```sql
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
BEGIN TRANSACTION;
SELECT balance FROM accounts WHERE id = 1; -- Transaction 2 might read 150.00 (dirty read)
COMMIT TRANSACTION;
```

#### Issue:
Session 1 reads uncommitted changes from Session 2, leading to dirty reads.

---

## 2. Read Committed

- Ensures that a transaction only reads committed data.
- Prevents **dirty reads** but allows **non-repeatable reads** and **phantom reads**.

### Example:
#### Session 1:
```sql
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
BEGIN TRANSACTION;
UPDATE accounts SET balance = 150.00 WHERE id = 1;
-- Transaction 1 does not commit yet
```
#### Session 2:
```sql
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
BEGIN TRANSACTION;
SELECT balance FROM accounts WHERE id = 1; -- Transaction 2 will read 100.00
COMMIT TRANSACTION;
```
#### Transaction 1:
```sql
COMMIT TRANSACTION;
```
#### Transaction 2 again:
```sql
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
BEGIN TRANSACTION;
SELECT balance FROM accounts WHERE id = 1; -- Transaction 2 will now read 150.00 (non-repeatable read)
COMMIT TRANSACTION;
```
#### Issue:
Transaction 2 reads different values in the same transaction due to transaction 1 committing.

---

## 3. Repeatable Read

- Ensures that if a row is read twice in the same transaction, the result is the same.
- Prevents **dirty reads** and **non-repeatable reads** but allows **phantom reads**.

### Example:
#### Session 1:
```sql
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
BEGIN TRANSACTION;
SELECT balance FROM accounts WHERE id = 1; -- Reads 100.00
-- Transaction 1 does not commit yet
```
#### Session 2:
```sql
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
BEGIN TRANSACTION;
UPDATE accounts SET balance = 150.00 WHERE id = 1;
COMMIT TRANSACTION;
```
#### Transaction 1 (again):
```sql
SELECT balance FROM accounts WHERE id = 1; -- Still reads 100.00 (repeatable read)
COMMIT TRANSACTION;
```

#### Issue:
New rows matching the condition may appear if another session inserts them, causing phantom reads.

---

## 4. Serializable

- The strictest isolation level, ensuring full consistency.
- Prevents **dirty reads**, **non-repeatable reads**, and **phantom reads**.
- Achieved by using locks or MVCC (Multiversion Concurrency Control).

### Example:
#### Session 1:
```sql
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
BEGIN TRANSACTION;
SELECT balance FROM accounts WHERE id = 1;
-- Transaction 1 does not commit yet.
```
#### Session 2:
```sql
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
BEGIN TRANSACTION;
UPDATE accounts SET balance = 150.00 WHERE id = 1;
COMMIT TRANSACTION;
```

#### Issue:
Transaction 2 will either have to wait until transaction 1 completes, or transaction 2 will be rolled back, depending on the database implementation. This avoids all concurrency issues, but also reduces it.

---

## Summary Table
| Isolation Level   | Dirty Reads | Non-Repeatable Reads | Phantom Reads |
|------------------|------------|----------------------|--------------|
| Read Uncommitted | ✅ Allowed  | ✅ Allowed           | ✅ Allowed   |
| Read Committed   | ❌ Prevented | ✅ Allowed           | ✅ Allowed   |
| Repeatable Read  | ❌ Prevented | ❌ Prevented         | ✅ Allowed   |
| Serializable     | ❌ Prevented | ❌ Prevented         | ❌ Prevented |

Choosing the right isolation level depends on the balance between performance and data consistency required for your application.

