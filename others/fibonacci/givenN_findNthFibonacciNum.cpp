#include <stdio.h>
#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

/*
 ----------------------------
 |Time Complexity:  O(log n)|
 |Space Complexity: O(log n)|
 ----------------------------

 ======== Solution ========
 Let Fn the n-th fabonacci number.
 Fn = Fn-1 + Fn-2 -- (1)

 Solve (1) recursively:
 Fn = (Fn-2 + Fn-3) + Fn-2 = 2Fn-2 + Fn-3
    = 2(Fn-3 + Fn-4) + Fn-3 = 3Fn-3 + 2Fn-4
    = ... = xp*Fp-1 + yp*Fp, where n > p, p-1 >= 1, xp and yp are positive integers
 
 Let Rn-p = {n-p, xp, yp} = {d, xp, yp}, where d = n-p.
                        
 Assume we have Rn, Rn+1, Rn+2:
 Rn   = {n,    x,  y}, i.e. Fn+2 = x*F1 + y*F2 (e.g. n, x and y all equal 1, then F3 = F1 + F2).
 Rn+1 = {n+1, x1, y1}, i.e. Fn+3 = x1*F1 + y1*F2,
 Rn+2 = {n+2, x2, y2}, i.e. Fn+4 = x2*F1 + y2*F2.
 Then, R2n+3, R2n+4, R2n+5 can be attained by formulae:
 (1) F2n+5 = x2*Fn+2 + y2*Fn+3 = x2*(x*F1 + y*F2) + y2*(x1*F1 + y1*F2)
 = (x2*x + y2*x1) * F1 + (x2*y + y2*y1) * F2
 <-> R2n+3 = {2n+3, x2*x + y2*x1, x2*y + y2*y1}
 (2) F2n+6 = x2*Fn+3 + y2*Fn+4 = x2*(x1*F1 + y1*F2) + y2*(x2*F1 + y2*F2)
 = (x2*x1 + y2*x2) * F1 + (x2*y1 + y2*y2) * F2 
 <-> R2n+4 = {2n+4, x2*x1 + y2*x2, x2*y1 + y2*y2}
 (3) F2n+7 = F2n+5 + F2n+6 
 <-> R2n+5 = {2n+5, R2n+3.x + R2n+4.x, R2n+3.y + R2n+4.y}

 Repeat the above process to get R with larger and larger d 
 and jump from a fibonacci number to a much larger fibonacci number using the R.
 */
typedef unsigned long long int ull;
struct R{
    int d; ull x, y;
    R(int d, ull x, ull y):d(d),x(x),y(y){}
};
struct RSet{
    R r, r2, r3; //r has the smallest d; r2's d = r's d + 1; r3's d = r's d + 2
    RSet(R r, R r2, R r3):r(r),r2(r2),r3(r3){}
};
struct Fn{
    int n; ull fn;
    Fn(){}
    Fn(int n, ull fn):n(n),fn(fn){}
    Fn* setN(int n){ this->n = n; return this; }
    Fn* setFn(ull fn){ this->fn = fn; return this; }
};
struct FnSet{
    Fn fn, fn2, fn3; //n = n2 - 1 = n3 - 2
    FnSet(){}
    FnSet(Fn fn, Fn fn2, Fn fn3):fn(fn),fn2(fn2),fn3(fn3){}
    FnSet* setFn(Fn fn){ this->fn = fn; return this; }
    FnSet* setFn2(Fn fn2){ this->fn2 = fn2; return this; }
    FnSet* setFn3(Fn fn3){ this->fn3 = fn3; return this; }
};

vector<RSet> rSetList;
FnSet fnSet;

void resetRSetListAndFnSet();
RSet getRSetWithLargerD();
void updateFnSetByR(const R &r);
ull getFnOfGivenN(const int n);

//A quick test on the implemented functions
int main(){
    cout << getFnOfGivenN(1) << endl; //1
    cout << getFnOfGivenN(89) << endl; //1779979416004714189
    cout << getFnOfGivenN(30) << endl; //832040
    cout << getFnOfGivenN(1) << endl; //1
    cout << getFnOfGivenN(3) << endl; //3
    cout << getFnOfGivenN(1) << endl; //1
    return 0;
}

void resetRSetListAndFnSet(){
    rSetList.clear();
    rSetList.push_back(RSet(R(1, 1, 1), R(2, 1, 2), R(3, 2, 3)));
    fnSet.setFn(Fn(1, 1))->setFn2(Fn(2, 1))->setFn3(Fn(3, 2));
}

RSet getRSetWithLargerD(){
    const RSet rSetWithMaxD = rSetList.back();
    const R rn = rSetWithMaxD.r, rnPlus1 = rSetWithMaxD.r2, rnPlus2 = rSetWithMaxD.r3;
    const int d = rn.d;
    const ull x = rn.x, y = rn.y, x1 = rnPlus1.x, y1 = rnPlus1.y, x2 = rnPlus2.x, y2 = rnPlus2.y;
    R r2nPlus3 = {2*d + 3, x2*x + y2*x1, x2*y + y2*y1};
    R r2nPlus4 = {2*d + 4, x2*x1 + y2*x2, x2*y1 + y2*y2};
    R r2nPlus5 = {2*d + 5, r2nPlus3.x + r2nPlus4.x, r2nPlus3.y + r2nPlus4.y};
    return RSet(r2nPlus3, r2nPlus4, r2nPlus5);
}

void updateFnSetByR(const R &r){
    const int n = fnSet.fn.n;
    const ull oldFn = fnSet.fn.fn, oldFnPlus1 = fnSet.fn2.fn, oldFnPlus2 = fnSet.fn3.fn;
    const int d = r.d;
    const ull x = r.x, y = r.y;
    Fn new1stFn = {d + n + 1, x * oldFn + y * oldFnPlus1};
    Fn new2ndFn = {d + n + 2, x * oldFnPlus1 + y * oldFnPlus2};
    Fn new3rdFn = {d + n + 3, new1stFn.fn + new2ndFn.fn};
    
    fnSet.setFn(new1stFn)->setFn2(new2ndFn)->setFn3(new3rdFn);
}

ull getFnOfGivenN(const int n){
    resetRSetListAndFnSet();
    fnSet.setFn(Fn(1, 1))->setFn2(Fn(2, 1))->setFn3(Fn(3, 2));
    
    ull result = -1;
    
    while (rSetList.back().r3.d + fnSet.fn.n + 3 < n){ //when a R with a larger d is needed
        rSetList.push_back(getRSetWithLargerD());
        updateFnSetByR(rSetList.back().r3);
    }
    
    int nOfLargestFn;
    int idxOfUsefulRSet = rSetList.size() - 1;
    while((nOfLargestFn = fnSet.fn3.n) < n){
        RSet rSet = rSetList[idxOfUsefulRSet];
        R r = rSet.r, r2 = rSet.r2, r3 = rSet.r3;
        if (r.d + fnSet.fn.n + 1 > n){
            idxOfUsefulRSet--;
        }else{
            if (r.d + fnSet.fn.n + 1 >= n && r.d + fnSet.fn.n + 3 <= n){ updateFnSetByR(r); }
            else if (r2.d + fnSet.fn.n + 1 >= n && r2.d + fnSet.fn.n + 3 <= n){ updateFnSetByR(r2); }
            else { updateFnSetByR(r3); }
        }
    }
    
    if (fnSet.fn.n == n){ result = fnSet.fn.fn; }
    else if (fnSet.fn2.n >= n){ result = fnSet.fn2.fn; }
    else { result = fnSet.fn3.fn; }
    
    return result;
}
