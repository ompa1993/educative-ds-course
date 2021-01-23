package StackAndQueue;

class CheckBalancedChallenge {
    public static boolean isBalanced(String exp) {
        // Write -- Your -- Code
        Stack<Character> paraStack = new Stack<>(exp.length());
        for (int i=0; i < exp.length(); i++){
            Character para = exp.charAt(i);

            switch (para){
                case '{':
                    paraStack.push('}');
                    break;

                case '(':
                    paraStack.push(')');
                    break;

                case '[':
                    paraStack.push(']');
                    break;

                case '}':
                    if (!paraStack.pop().equals('}')){
                        return false;
                    }
                    break;
                case ')':
                    if (!paraStack.pop().equals(')')){
                        return false;
                    }
                    break;
                case ']':
                    if (!paraStack.pop().equals(']')){
                        return false;
                    }
                    break;

            }
        }
        return paraStack.isEmpty();
    }
}