package leetcode;

/**
 * @Author: Alex.Z
 * @DATE: 2019/1/28
 * @Description:
 */
public class BinaryTreeMaxPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public int maxPathSum(TreeNode root) {
        MaxInt max = new MaxInt();
        maxSum(root,max);
        return max.max;
    }

    private class SumNode{
        public int s1=0;
        public int s2=0;

        public SumNode() {
        }

        public SumNode(int s1, int s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }

    private class MaxInt{
        public int max=Integer.MIN_VALUE;
    }

    private SumNode maxSum(TreeNode node , MaxInt maxNum){
        if(null == node) return new SumNode();
        SumNode leftSum = maxSum(node.left, maxNum);
        SumNode rightSum = maxSum(node.right, maxNum);
        SumNode sumNode = new SumNode();
        int tmp = leftSum.s1>rightSum.s1? leftSum.s1:rightSum.s1;
        if(tmp<=0) sumNode.s1 = node.val;
        else sumNode.s1 = tmp+node.val;
        sumNode.s2=leftSum.s1+rightSum.s1+node.val;
        if(sumNode.s1>maxNum.max) maxNum.max = sumNode.s1;
        if(sumNode.s2>maxNum.max) maxNum.max = sumNode.s2;
        return sumNode;
    }

}
