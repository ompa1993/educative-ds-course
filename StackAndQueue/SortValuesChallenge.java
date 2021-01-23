package StackAndQueue;

class SortValuesChallenge {
    public static void sortStack(Stack<Integer> stack) {
        // Write -- Your -- Code
        int stackSize = stack.getCurrentSize();
        Stack<Integer> tmpStack = new Stack<>(stackSize);
        for (int i=0; i < stackSize; i++){
            int currentMax = stack.pop();
            int j = 0;
            while (j < (stackSize - 1 - i)){
                int tmp = stack.pop();
                if (tmp > currentMax){
                    tmpStack.push(currentMax);
                    currentMax = tmp;
                    j++;
                }
                else{
                    tmpStack.push(tmp);
                    j++;
                }
            }
            stack.push(currentMax);
            while(!tmpStack.isEmpty()){
                stack.push(tmpStack.pop());
            }
        }
    }
}