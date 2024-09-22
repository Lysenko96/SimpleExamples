package com.lysenko.springquicklytransaction.service;

import com.lysenko.springquicklytransaction.model.Account;
import com.lysenko.springquicklytransaction.repository.AccountRepositoryCrud;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransferServiceTest {

    @Mock
    private AccountRepositoryCrud accountRepository;
    @InjectMocks
    private TransferService transferService;

    @BeforeEach
    void setUp() {
//        accountRepository = mock(AccountRepositoryCrud.class);
//        transferService = new TransferService(accountRepository);
    }

    @Test
    void testTransfer() {
        Account sender = new Account(1L, "Tony", new BigDecimal(1000));
        Account receiver = new Account(2L, "John", new BigDecimal(1000));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));

        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        transferService.transfer(sender.getId(), receiver.getId(), new BigDecimal(100));

        verify(accountRepository).changeBalance(1L, new BigDecimal(900));
        verify(accountRepository).changeBalance(2L, new BigDecimal(1100));
    }

    @Test
    void testTransferWithException() {
        Account sender = new Account(1L, "Tony", new BigDecimal(1000));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));

        when(accountRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> transferService.transfer(sender.getId(), 2L, new BigDecimal(100)));

        verify(accountRepository, never()).changeBalance(anyLong(), any());
    }

}