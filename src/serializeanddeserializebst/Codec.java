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
package serializeanddeserializebst;

public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    StringBuilder builder = new StringBuilder();
    builder.append(root.val).append(',');
    if (root.left != null) {
      builder.append(serialize(root.left));
    }
    if (root.right != null) {
      builder.append(serialize(root.right));
    }

    return builder.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("")) {
      return null;
    }
    TreeNode curr = null;
    String[] splittedData = data.split(",");
    for (String currNodeStr : splittedData) {
      int currVal = Integer.parseInt(currNodeStr);
      if (curr == null) {
        curr = new TreeNode(currVal);
      } else {
        insert(curr, currVal);
      }
    }

    return curr;
  }

  private TreeNode insert(TreeNode node, int val) {
    if (val <= node.val) {
      if (node.left == null) {
        node.left = new TreeNode(val);
      } else {
        insert(node.left, val);
      }
    } else {
      if (node.right == null) {
        node.right = new TreeNode(val);
      } else {
        insert(node.right, val);
      }
    }
    return null;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(2);
    TreeNode node = new Codec().deserialize(new Codec().serialize(root));
    System.out.println();
  }
}
