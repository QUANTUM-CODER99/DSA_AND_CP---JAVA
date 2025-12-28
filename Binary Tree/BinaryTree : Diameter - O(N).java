    // FINDING THE DIAMETER OF TREE -> O(N)
    public static class Information {
        int diam , height;
        Information(int diam , int height) {
            this.diam = diam;
            this.height = height;
        }
    }

    public static Information diameter2(Node root) {
       if(root == null) {
           return new Information(0, 0);
       }

       Information leftT = diameter2(root.left);
       Information rightT = diameter2(root.right);

       int height = Math.max(leftT.height, rightT.height) + 1;

       int diam1 = leftT.height + rightT.height + 1;
       int diam2 = leftT.diam;
       int diam3 = rightT.diam;

       int diam = Math.max(diam1, Math.max(diam2, diam3));

       return new Information(diam, height);
   }
