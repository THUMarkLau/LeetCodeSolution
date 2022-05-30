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
package sumofroottoleafbinarynumbers;

import commons.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Solution {
  List<String> values = new LinkedList<>();
  StringBuilder builder = new StringBuilder();

  public int sumRootToLeaf(TreeNode root) {
    visitRecursively(root);
    int sum = 0;
    for (String value : values) {
      sum += string2Int(value);
    }
    return sum;
  }

  int string2Int(String str) {
    char[] chars = str.toCharArray();
    int sum = 0;
    for (int idx = chars.length - 1; idx >= 0; --idx) {
      sum += (chars[idx] - '0') << (chars.length - idx - 1);
    }
    return sum;
  }

  void visitRecursively(TreeNode node) {
    builder.append(node.val == 0 ? '0' : '1');
    if (node.left != null) {
      visitRecursively(node.left);
    }
    if (node.right != null) {
      visitRecursively(node.right);
    }
    if (node.right == null && node.left == null) {
      values.add(builder.toString());
    }

    builder.deleteCharAt(builder.length() - 1);
  }

  public static void main(String[] args) {
    int[] r = new int[1000];
    for (int i = 0; i < r.length; ++i) {
      r[i] = new Random().nextInt(2);
    }
    System.out.println(Arrays.toString(r));
    TreeNode node = TreeNode.buildTree(r);
    System.out.println(
        new Solution().sumRootToLeaf(TreeNode.buildTree(new int[] {1, 0, 0, 0, 1, 0, 1, 1})));
  }
}
