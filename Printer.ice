module Demo
{
    interface Printer
    {
        void printString(string s);
        string toUpper(string s);
        int stringLength(string s);
        string repeat(string s, int times);
    }

    interface Calculator
    {
        int add(int a, int b);
        int multiply(int a, int b);
        string describe();
    }
}
