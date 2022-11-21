matrixX = [4,7,8,5]
matrixY = [3,2,7,5]
matrixA = [9,7,6,2]

def transpose(function):
    def wrapper(*semua):
        matrix = function(*semua)
        matrix[1], matrix[2] = matrix[2], matrix[1]
        return matrix
    return wrapper

@transpose
def Tmatrix(m):
    Tm = m
    return Tm

def penjumlahanMatrix(function1, function2):
    result = []
    for i in range(0, len(function1)):
        result.append(function1[i] + function2[i])
    return result

def perkalianMatrix(matrix1):
    def kali(matrix2):
        AtX = [matrix1[0]*matrix2[0] + matrix1[1]*matrix2[2],matrix1[0]*matrix2[1] + matrix1[1]*matrix2[3],matrix1[2]*matrix2[0] + matrix1[3]*matrix2[2],matrix1[2]*matrix2[1] + matrix1[3]*matrix2[3]]
        return AtX
    return kali

@transpose
def resultMatrix(X,Y,A):
    Z = perkalianMatrix(Tmatrix(A))(X)
    result = penjumlahanMatrix(Tmatrix(Y),Z)
    return result

print(resultMatrix(matrixX,matrixY,matrixA))