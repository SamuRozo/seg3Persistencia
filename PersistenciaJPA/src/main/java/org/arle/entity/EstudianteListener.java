package org.arle.entity;

import jakarta.persistence.*;

public class EstudianteListener {

    @PrePersist
    public void prePersist(Estudiante producto) {
        System.out.println("Estudiante a ser persistido: " + producto);
    }

    @PostPersist
    public void postPersist(Estudiante producto) {
        System.out.println("Estudiante persistido: " + producto);
    }

    @PreUpdate
    public void preUpdate(Estudiante producto) {
        System.out.println("Estudiante a ser actualizado: " + producto);
    }

    @PostUpdate
    public void postUpdate(Estudiante producto) {
        System.out.println("Estudiante actualizado: " + producto);
    }

    @PreRemove
    public void preRemove(Estudiante producto) {
        System.out.println("Estudinate a ser eliminado: " + producto);
    }

    @PostRemove
    public void postRemove(Estudiante producto) {
        System.out.println("Estudiante eliminado: " + producto);
    }
}
