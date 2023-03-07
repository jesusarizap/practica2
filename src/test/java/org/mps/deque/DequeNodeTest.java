package org.mps.deque;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {

    DequeNode nodo;

    @BeforeEach
    void setup()
    {
        nodo = new DequeNode(1, null, null);
    }

    @AfterEach
    void shutdown()
    {
        nodo = null;
    }

    @Nested
    @DisplayName("Test cases for the DequeNode implementation")
    void TestDePrueba(){

    }

}
