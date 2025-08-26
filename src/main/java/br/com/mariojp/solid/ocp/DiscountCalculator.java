package br.com.mariojp.solid.ocp;

public class DiscountCalculator {
    private DiscountPolicy discountPolicy;


    public DiscountCalculator(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }


    public DiscountCalculator(CustomerType type) {
        this.discountPolicy = DiscountPolicyFactory.getPolicy(type);
    }


    public DiscountCalculator() {
    }

    public double apply(double amount) {
        if (discountPolicy == null) {
            throw new IllegalStateException("Política de desconto não definida");
        }
        return discountPolicy.calculateDiscount(amount);
    }


    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = DiscountPolicyFactory.getPolicy(type);
        return policy.calculateDiscount(amount);
    }


    public void setPolicy(DiscountPolicy policy) {
        this.discountPolicy = policy;
    }
}