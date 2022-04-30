package com.mikhalevich.pecs.exampleone;

@FunctionalInterface
interface Predicate<E> {
    /**
     * Возвращает true, если значение удовлетворяет
     * условию, false в противном случае.
     *
     * @param exp Выражение для проверки.
     * @return true, если удовлетворяет; false, если нет.
     */
    boolean apply(E exp);
}
