class Solution {
    fun solution(num_list: IntArray): Int {
        
        var even: String = num_list.filter{it % 2 == 0}.joinToString(separator = ""){it.toString()}
        var odd: String = num_list.filter{it % 2 != 0}.joinToString(separator = "") {it.toString()}
        
        return Integer.parseInt(even) + Integer.parseInt(odd)
        
//         ------------------------------------------
//         var even:String = ""
//         var odd: String = ""
        
//         for (num in num_list) {
//             if (num % 2 == 0) {
//                 even += num
//             } else {
//                 odd += num
//             }
//         }
        
//         return Integer.parseInt(even) + Integer.parseInt(odd)
        
    }
}