package com.serenitydojo.serenitybank.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WhenOnboardingACustomer {
    @Test
    void aNewCustomerShouldGetAUniqueCustomerId() {
        Customer newCustomer = Customer.withName("Chris","Customer");
        assertThat(newCustomer.getId()).isNotEmpty();
    }
}
