package main

func main() {

}

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	p := list1
	q := list2
	r := &ListNode{-1, nil}
	cur := r
	for p != nil && q != nil {
		if q.Val < p.Val {
			cur.Next = q
			q = q.Next
		} else {
			cur.Next = p
			p = p.Next
		}
		cur = cur.Next
	}
	if q != nil {
		cur.Next = q
	}
	if p != nil {
		cur.Next = p
	}
	return r.Next
}
