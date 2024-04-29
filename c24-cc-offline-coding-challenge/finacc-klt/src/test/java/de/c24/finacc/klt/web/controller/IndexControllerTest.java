package de.c24.finacc.klt.web.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

/**
 * IndexControllerTest
 */
class IndexControllerTest {

    private IndexController indexController = new IndexController();

    @Test
    @DisplayName("Simple test")
    void index() {
        Model model = new BindingAwareModelMap();
        String result = indexController.index(model);
        assertThat(result).isEqualTo("index");
        assertThat(model.getAttribute("title")).isEqualTo("Karten&Konten KLT");
    }
}
