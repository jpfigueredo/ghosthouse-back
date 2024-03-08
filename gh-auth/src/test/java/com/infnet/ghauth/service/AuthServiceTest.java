package com.infnet.ghauth.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.infnet.ghauth.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AuthServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAccountById() {
        long accountId = 1L;
        Account mockAccount = new Account();
        mockAccount.setId(accountId);
        mockAccount.setUsername("john_doe");

        when(usuarioRepository.findById(accountId)).thenReturn(Optional.of(mockAccount));

        Optional<Account> result = usuarioService.findAccountById(accountId);

        assertEquals(mockAccount, result.orElse(null));
    }

    // Outros testes para os métodos do AccountService...
}
