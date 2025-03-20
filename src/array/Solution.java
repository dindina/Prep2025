package array;

import java.util.*;

class Solution {

    //products [[100, dcoupon1], [50, dcoupon1], [30, dcoupon1], [100, dcoupon2], [50, dcoupon2], [30, dcoupon2]]

    //discounts [[dcoupon1, 0, 60], [dcoupon1, 1, 30], [dcoupon1, 1, 20], [dcoupon2, 2, 20], [dcoupon2, 1, 85], [dcoupon2, 0, 15]]

    /*
    6
2
100 dcoupon1
50 dcoupon1
30 dcoupon1
100 dcoupon2
50 dcoupon2
30 dcoupon2
6
3
dcoupon1 0 60
dcoupon1 1 30
dcoupon1 1 20
dcoupon2 2 20
dcoupon2 1 85
dcoupon2 0 15
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> products = new ArrayList<>();
        products.add(Arrays.asList("100", "dcoupon1"));
        products.add(Arrays.asList("50", "dcoupon1"));
        products.add(Arrays.asList("30", "dcoupon1"));
        products.add(Arrays.asList("100", "dcoupon2"));
        products.add(Arrays.asList("50", "dcoupon2"));
        products.add(Arrays.asList("30", "dcoupon2"));


        List<List<String>> discounts = new ArrayList<>();
        discounts.add(Arrays.asList("dcoupon1", "0", "60"));
        discounts.add(Arrays.asList("dcoupon1", "1", "30"));
        discounts.add(Arrays.asList("dcoupon1", "1", "20"));
        discounts.add(Arrays.asList("dcoupon2", "2", "20"));
        discounts.add(Arrays.asList("dcoupon2", "1", "85"));
        discounts.add(Arrays.asList("dcoupon2", "0", "15"));

        int result = solution.findLowestPrice(products, discounts);
        System.out.println(result); // Output: 35
    }


    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {
        // Write your code here
        Map<String,List<Discount>> discountMap = new HashMap<>();
        int totalPrice =0;
        for(List<String> discount : discounts){
            //System.out.println("discount is " + discount);
            String tag = discount.get(0);
            int type = Integer.parseInt(discount.get(1));
            double amount = Double.parseDouble(discount.get(2));

            if(!discountMap.containsKey(tag)){
                discountMap.put(tag , new ArrayList<>());
            }
            else{
                List<Discount> discountsForTag = discountMap.get(tag);
                System.out.println("tag " + tag );
                System.out.println("existing " + discountsForTag );
                boolean updated = false;
                for (int i = 0; i < discountsForTag.size(); i++) {

                    if (discountsForTag.get(i).type == type) {
                        //System.out.println("existing type " + discountsForTag.get(i).type);
                        //System.out.println("new amount amount" + amount);
                        //System.out.println("old amount amount" + discountsForTag.get(i).amount);
                        if (amount > discountsForTag.get(i).amount) {
                            discountsForTag.set(i, new Discount(type, amount)); // Update with lower amount

                        }
                        updated = true;
                        break;
                    }
                }
                if (!updated) {
                    discountsForTag.add(new Discount(type, amount)); // Add new discount
                }
                System.out.println("new " + discountsForTag );

            }

        }
        System.out.println("discountMap " + discountMap);
        //System.out.println("products " + products);
        //System.out.println("discounts " + discounts);
        for(List<String> product : products){
            int price= Integer.parseInt(product.get(0));

            System.out.println("price ------------" + price);
            int minPrice = price;
            for(int i = 1; i < product.size(); i++){
                String tag = product.get(i);
                //System.out.println("tag " + tag);
                if(!tag.equals("EMPTY")){
                    List<Discount> discountList = discountMap.get(tag);
                    if(discountList != null){
                        for(Discount d : discountList){
                            int newPrice = calculate(d,price);
                            //System.out.println("newPrice " + newPrice);
                            minPrice = Math.min(minPrice, newPrice);

                        }
                    }
                }

                //System.out.println("totalPrice " + totalPrice);
            }
            totalPrice += minPrice;
        }

        return totalPrice;


    }

    public static int calculate(Discount Discount, int price ){

        switch(Discount.type){
            case 0: return (int) Discount.amount;
            case 1: return (int) Math.round(price * (1 - Discount.amount / 100.0));
            case 2: return (int) (price - Discount.amount);
            default:
                return price;

        }
    }

    static class Discount{
        int type;
        double amount;
        public Discount(int type, double amount){
            this.type= type;
            this.amount = amount;
        }
        @Override
        public String toString()
        {
            return "type->"+type+",amount->"+amount;
        }
    }


}
