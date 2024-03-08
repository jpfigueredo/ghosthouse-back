package com.infnet.ghpayment.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.infnet.ghpayment.domain.Payment;
import com.infnet.ghpayment.dto.PaymentDTO;
import com.infnet.ghpayment.repository.PaymentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessPayment() {
        // Simular um novo pagamento
        Payment payment = new Payment();
        payment.setAmount(100.00);
        payment.setUserId(1L);

        PaymentDTO paymentDTO = new PaymentDTO();
        payment.setAmount(100.00);
        payment.setUserId(1L);

        // Simular o processamento do pagamento no repositório
        when(paymentRepository.save(payment)).thenReturn(payment);

        // Chamar o método para processar o pagamento
        PaymentDTO result = paymentService.processPayment(paymentDTO);

        // Verificar se o pagamento foi processado corretamente
        assertEquals(payment, result);
    }

    // Outros testes para os métodos do PaymentService...
}
