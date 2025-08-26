package br.com.mariojp.solid.ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountPolicyFactory {
    private static final Map<CustomerType, DiscountPolicy> policies = new HashMap<>();

    static {
        policies.put(CustomerType.REGULAR, new RegularCustomerDiscount());
        policies.put(CustomerType.PREMIUM, new PremiumCustomerDiscount());
        policies.put(CustomerType.PARTNER, new PartnerCustomerDiscount());
    }

    public static void registerPolicy(CustomerType customerType, DiscountPolicy discountPolicy) {
        policies.put(customerType, discountPolicy);
    }

    public static DiscountPolicy getPolicy(CustomerType type) {
        return policies.getOrDefault(type, amount -> 0);
    }
}
