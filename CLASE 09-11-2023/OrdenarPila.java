// debe invocar el metodo PilasSort() en su funcion principal
public static void PilasSort() {
    Stack<Integer> s = new Stack<Integer>();
    int n = in.nextInt();
    while(n-- > 0) {
        int x = in.nextInt();
        s.add(x);
    }
    
    Stack<Integer> aux = new Stack<Integer>();
    Stack<Integer> resp = new Stack<Integer>();
    
    while(s.size() > 0) {
        
        int val = s.pop();
        aux.add(val);
        while(s.size() > 0) {
            int val2 = s.pop();
            val = Math.max(val, val2);
            aux.add(val2);
        }
        
        while(aux.size() > 0) {
            int val2 = aux.pop();
            if(val2 == val) {
                resp.add(val2);
            }else
                s.add(val2);
        }
    }
    
    while(resp.size() > 0) {
        int val = resp.pop();
        System.out.println(val);
    }
    
}
