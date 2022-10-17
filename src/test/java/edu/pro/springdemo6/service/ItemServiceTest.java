package edu.pro.springdemo6.service;

import edu.pro.springdemo6.model.Item;
import edu.pro.springdemo6.repository.ItemMongoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ItemServiceTest {

    @Mock
    private ItemMongoRepository repository;

    @InjectMocks
    private ItemService itemService;

    @Test
    void testCreate() {
        //given
        Item item = new Item();
        item.setName("name");
        Mockito.when(repository.save(item)).thenReturn(item);

        //when
        Item createdItem = itemService.create(item);

        //then
        assertEquals("name", createdItem.getName());
    }

    @Test
    void testCreateShouldThrowRuntimeExceptionWhenItemIsNull() {
        //given
        //when
        //then
        assertThrows(RuntimeException.class, () -> {
            itemService.create(null);
        });
    }

    @Test
    void testDelete() {
        //given
        Mockito.doNothing().when(repository).deleteById("1");

        //when
        itemService.delete("1");

        //then
        Mockito.verify(repository).deleteById("1");
    }
}