package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public List<CartItem> getCrt() {
        return cartRepository.selectAllItems();
    }

    public void addItm(CartItem item) {
        cartRepository.insertOrIncrementItem(item);
    }

    public void removeItm(CartItem item) {
        cartRepository.deleteOrDecrementItem(item);
    }

    public void clearCrt(boolean restock) {
        cartRepository.deleteAllItems(restock);
    }
}


