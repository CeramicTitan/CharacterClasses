package me.ceramictitan.me.ceramictitan.packet;

public interface MethodAccessor<T> {

    T invoke(Object instance, Object... args);

}