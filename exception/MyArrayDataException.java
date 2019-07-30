package exception;

public class MyArrayDataException extends NumberFormatException {
    int i, j;

    MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
