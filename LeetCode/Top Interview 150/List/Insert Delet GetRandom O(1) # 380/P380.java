import java.util.ArrayList;

class RandomizedSet {
    ArrayList <Integer> cases ;
    public RandomizedSet() {
        cases = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(cases.contains(val)) return false;
        cases.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!cases.contains(val)) return false;
        cases.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        int randomIndex = (int)(Math.random()*cases.size());
        return cases.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
