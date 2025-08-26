package br.com.mariojp.solid.ocp;

public class PartnerCustomerDiscount implements DiscountPolicy{
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.88;
    }
}
