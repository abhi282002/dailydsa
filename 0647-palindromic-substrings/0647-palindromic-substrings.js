/**
 * @param {string} s
 * @return {number}
 */


var countSubstrings = function(s) {
    let  n = s.length;
    let t = Array.from({length : 1001},()=>Array(1001).fill(undefined))
    let count = 0;
    for(let L = 1; L <= n; L++){
        for(let i = 0; i + L - 1 < n; i++){
            let j = i + L -1
            if(i == j){
                t[i][j] = true
            }else if((i + 1) == j){ 
                  t[i][j] = (s[i] == s[j]) 
            }else{
                t[i][j] = s[i] == s[j] && t[i+1][j-1]
            }
            if(t[i][j] == true){
                count += 1
            }
        }
    }
    return count
};

