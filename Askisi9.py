#python program to find maximum contiguous subarray and its sum
from sys import maxsize

def maxSequence(a,size):
	
	max_so_far=-maxsize-1
	max_ending_here=0
	start=0
	end=0
	s=0
	#we try to find the starting and ending index
	for i in range(0,size):
		max_ending_here+=a[i]
		
		
		if max_so_far<max_ending_here:
			max_so_far=max_ending_here
			start=s
			end=i
		if max_ending_here<0:
			max_ending_here=0
			s=i+1
	print("Maximum contiguous sum is %d"%(max_so_far))
	print (a[start:end+1])
numbers=input("Enter numbers seperated by space: ").split()
a=[int(x) for x in numbers]
print ("You gave",a[:])
#calling the function
maxSequence(a,len(a))
