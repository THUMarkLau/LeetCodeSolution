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
package commons;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode buildTree(int[] values) {
    TreeNode root = null;
    TreeNode[] nodes = new TreeNode[values.length];
    for (int i = 0; i < values.length; ++i) {
      if (root == null) {
        root = new TreeNode(values[i]);
        nodes[i] = root;
      } else {
        nodes[i] = new TreeNode(values[i]);
        if (i % 2 == 0) {
          nodes[i / 2 - 1].right = nodes[i];
        } else {
          nodes[(i - 1) / 2].left = nodes[i];
        }
      }
    }
    return root;
  }
}
