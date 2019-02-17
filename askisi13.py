#insert distances into the list 
def get_values():
	my_list=[]
	again='yes'
	while again=="yes":
		dis=float(input('Give me  distance you want to insert: '))
		while dis<0:
			print ('The distance cannot be negative number!!!!')
			dis=float(input('Give me  distance you want to insert: '))
		my_list.append(dis)
		print('Do you want to insert more distances?')
		again=input('yes if you want to continue, or anything else that type means no:')
		print()
	return my_list
#this distance calculate the maximum sum
#We use continuous loops starting at different indexes each items 
#in order to find the maximum sum of the elements of the list in order to be smaller than the second 
#positive argument that the user gave.
def maxDistance(d_list,numb):
	max=0
	t=len(d_list)
	for j in range (0,t):
		s=0
		for i in range(j,t):
			if s+d_list[i]<=numb:
				s=s+d_list[i]
		if s>max:
			max=s
		if j!=0:
				for k in range(0,j):
					if s+d_list[k]<=numb:
						s=s+d_list[k]
				if s>max:
					max=s
	print("the maximum distance that you can travel is ",max)


distance=get_values()
print ("The numbers of the list is: ")
print (distance)
number=int(input('Give me a positive  number: '))
while number<0:
	print ('The distance cannot be negative number')
	number=int(input('Give me a positive number: '))
print ("you gave",number)
maxDistance(distance,number)