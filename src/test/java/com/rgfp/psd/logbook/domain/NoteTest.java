package com.rgfp.psd.logbook.domain;

import com.rgfp.psd.logbook.service.NoteService;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NoteTest {

    @Test
    public void testRecibirResumenVacio() {
        //Arrange
        Note nota = new Note();

        //Act
        String contenido = nota.getSummary();

        //Assert
        assertEquals(null, contenido);

    }

    @Test
    public void testRecibirResumenShalito() {
        //Arrange
        Note nota = new Note();
        nota.setContent("shalito");

        //Act
        String contenido = nota.getSummary();

        //Assert
        assertEquals("shalito", contenido);
    }

    @Test
    public void testRecibirResumen10Caracteres() {
        //Arrange
        Note nota = new Note();
        nota.setContent("Hoy es un buen día para morir.");

        //Act
        String contenido = nota.getSummary();

        //Assert
        assertEquals("Hoy es un ", contenido);
    }

    @Test
    public void testRecibirResumen10CaracteresCuandoContenidoEsMenor() {
        //Arrange
        Note nota = new Note();
        nota.setContent("Hola!");

        //Act
        String contenido = nota.getSummary();

        //Assert
        assertEquals("Hola!", contenido);
    }

    @Test
    public void testNoteFindAllBy(){

        //Arrange
        NoteService servicio = mock(NoteService.class);
        Note nota = new Note();
        nota.setContent("Hola que talca");
        when(servicio.findOne((long) 1)).thenReturn(Optional.ofNullable(nota));

        //Act
        String summary = nota.getSummary();

        //Assert
        assertEquals("Hola que t", summary);
    }
}