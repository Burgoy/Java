В данной папке написаны алгоритмы сортировки массива.
1. Bubble - Алгоритм сравнивает одно число со следующим и если оно больше то преремещается веред смещяя назад меньшие числа. Класс содержит методы:
    CreateMasive() - отвечает за заполнения массива
    SortPuz() - возвращает отсортированный массив
2. Selection - Алгоритм заключается в поиске наименьшего элемента в массиве и перемещении его на нулевую позицию, при дальнейшем поиске меняем на индекс +1.
3. Quick - метод сортировки делящий массив на две части на основе выбраного элемента, элементы с лева должны быть меньше, а справа больше. Затем процесс повторяется для двух массивов деля их на подмассивы пока каждый элемент не будет осортировант.