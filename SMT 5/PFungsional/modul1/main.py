# Soal NIM GENAP
is_logged_in = False
logged_in_as = None

teacher_user = ["budi", "saip", "ari"]
teacher_pass = ["12345","34251","54321"]

student_user = ["pangestu", "agam", "aristyo"]
student_pass = ["apalah123","terserah123","karepm123"]
student_name = ["Syahrul Pangestu", "Ridha Agam", "Rizaldy Aristyo"]
midterm_score = [98,97,99]
finalexam_score = [97,98,99]

def student_menu(student_id):
    print("Welcome", student_user[student_id],"!")
    print("Midterm Score:",midterm_score[student_id])
    print("Final Exam Score:",finalexam_score[student_id])
    print("Grand Finale:", (midterm_score[student_id]+finalexam_score[student_id])/2)
    input("Press Enter to logout")

def data_entry(choice):
    if choice==1:
        print('(EDIT MODE) - Student List')
        for i in student_user:
            uname_id = student_user.index(i)
            print(uname_id,"|",student_name[uname_id],", UTS:",midterm_score[uname_id],", UAS",finalexam_score[uname_id])
        selected_id = int(input('Select Student By id:'))
        if selected_id > len(student_user):
            print('editting id', selected_id)
            if input('Edit Student Name?: ') != 'n' or 'N':
                student_name[selected_id] = input(student_name[selected_id], " ---> ")
            if input('Edit Midterm Score?: ') != 'n' or 'N':
                student_name[selected_id] = int(input(midterm_score[selected_id], " ---> "))
            if input('Edit Final Exam Score?: ') != 'n' or 'N':
                student_name[selected_id] = int(input(finalexam_score[selected_id], " ---> "))
        else: print("there's no such id")
    else:
        print('(NEW ENTRY) - Student Entry')
        student_user.append(input("Insert new username: "))
        student_pass.append(input("Insert new password: "))
        student_name.append(input("Insert new Student Name: "))
        midterm_score.append(int(input("Insert new Midterm Score: ")))
        finalexam_score.append(int(input("Insert new FinalEx Score: ")))
        print("Data Inserted Successfully")

def score_edit(the_array):
    for i in student_user:
        uname_id = student_user.index(i)
        print(uname_id,"|",student_name[uname_id],", UTS:",midterm_score[uname_id],", UAS",finalexam_score[uname_id])
    selected_id = input('Select By ID: ')
    if selected_id > len(the_array):
        print('editting', selected_id)
    else: print("there's no such id")

def teacher_menu(teacher_id):
    loop=True
    print("Get Back to work", teacher_user[teacher_id],"!")
    while loop:
        choice = int(input("=== Teacher's Menu ===\n1. Data Entry/Edit\n2. Score Edit\n3. Logout\n"))
        if choice == 1:
            choice = int(input('1.Edit\n2.New\nSelect:'))
            if choice==1: data_entry(1)
            elif choice==2: data_entry(2)
            else: print("invalid choice!")
        elif choice == 2:
            print('1.Midterm\n2.Final Exam\nSelect:')
            choice = input()
            if choice==1: score_edit(midterm_score)
            elif choice==2: score_edit(finalexam_score)
            else: print("invalid choice!")
        elif choice == 3: loop=False
        else: print("invalid choice!")

def login():
    while True:
        user_in = input('Username: ')
        if user_in in student_user:
            pass_in = input('Student Password: ')
            if pass_in == student_pass[student_user.index(user_in)]:
                student_menu(student_user.index(user_in))
            else: print("wrong pass!")
        elif user_in in teacher_user:
            pass_in = input('Teacher Password: ')
            if pass_in == teacher_pass[teacher_user.index(user_in)]:
                teacher_menu(teacher_user.index(user_in))
            else: print("wrong pass!")
        else: print(user_in,"is not on the list!")

login()
