/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package successorlcci;

public class Solution {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root.val == p.val) {
      TreeNode curr = p.right;
      while (curr != null && curr.left != null) {
        curr = curr.left;
      }
      return curr;
    } else if (p.right != null) {
      TreeNode curr = p.right;
      while (curr.left != null) {
        curr = curr.left;
      }
      return curr;
    } else {
      TreeNode curr;
      TreeNode prev;

      if (p.val < root.val) {
        curr = root.left;
        prev = root;
      } else {
        curr = root.right;
        prev = null;
      }

      while (curr.val != p.val) {
        if (p.val < curr.val) {
          prev = curr;
          curr = curr.left;
        } else {
          curr = curr.right;
        }
      }
      return prev;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);
    System.out.println(new Solution().inorderSuccessor(root, root.right));
  }
}
