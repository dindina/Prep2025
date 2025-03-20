package array;

import java.util.*;

public class DiscountCalculator {
    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {
        // Store the best discount per tag
        Map<String, Integer> bestDiscountPriceMap = new HashMap<>();

        for (List<String> discount : discounts) {
            String tag = discount.get(0);
            int type = Integer.parseInt(discount.get(1));
            int amount = Integer.parseInt(discount.get(2));

            // Initialize best price for this tag
            bestDiscountPriceMap.putIfAbsent(tag, Integer.MAX_VALUE);

            int discountedPrice;
            if (type == 0) {
                discountedPrice = amount;
            } else if (type == 1) {
                discountedPrice = amount; // Store percentage discount amount
            } else {
                discountedPrice = -amount; // Store fixed reduction amount
            }

            // Keep the best discount price for this tag
            bestDiscountPriceMap.put(tag, Math.min(bestDiscountPriceMap.get(tag), discountedPrice));
        }

        int totalCost = 0;
        for (List<String> product : products) {
            int price = Integer.parseInt(product.get(0));
            int minPrice = price;

            for (int i = 1; i < product.size(); i++) {
                String tag = product.get(i);
                if (bestDiscountPriceMap.containsKey(tag)) {
                    int bestDiscount = bestDiscountPriceMap.get(tag);
                    int discountedPrice = price;

                    if (bestDiscount >= 0) { // Type 0 or Type 1
                        if (price > 100) {
                            discountedPrice = (int) Math.round(price * (1 - bestDiscount / 100.0)); // Percentage discount
                        } else {
                            discountedPrice = bestDiscount; // Fixed price
                        }
                    } else { // Type 2
                        discountedPrice = Math.max(0, price + bestDiscount);
                    }

                    minPrice = Math.min(minPrice, discountedPrice);
                }
            }

            totalCost += minPrice;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        DiscountCalculator solution = new DiscountCalculator();
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
}

