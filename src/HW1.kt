fun main(args: Array<String>) {
    // 학생 수 입력
    print("Enter the total number of students: ")
    val numOfStudents: Int = readlnOrNull()?.toIntOrNull() ?: 0  //elvis operator : null일때 0으로 지정

    // 학생 ID와 점수 배열 초기화(NULL일 수 있음을 정의)// kotlin에서는 기본적으로 null 허용 안함
    val idArray = arrayOfNulls<Long>(numOfStudents)
    val scoreArray = arrayOfNulls<Int>(numOfStudents)

    // 각 학생의 ID와 점수 입력 받기
    for (i in 0 until numOfStudents) {
        println("${i}-th Student")  // $i-th 부분을 수정
        print("Enter ID: ")
        idArray[i] = readlnOrNull()?.toLongOrNull()  //safecall 사용 객체가 null일경우 null 반환후 뒤에 연산 진행
        print("Enter Score: ")
        scoreArray[i] = readlnOrNull()?.toIntOrNull()
    }

    // 평균 점수 계산
    var sum: Int = 0
    val validScores = scoreArray.filterNotNull() // null이 아닌 점수만 필터링
    for (score in validScores) {
        sum += score
    }

    // validScores가 비어있을 때 NaN 반환
    val avgScore = if (validScores.isNotEmpty()) {
        sum.toFloat() / validScores.size
    } else {
        Float.NaN  // NaN을 반환
    }

    // 최고 점수와 최저 점수 및 해당 학생 ID 찾기
    var highestScore: Int? = null
    var lowestScore: Int? = null
    var highestId: Long? = null
    var lowestId: Long? = null

    for (i in 0 until numOfStudents) {
        val score = scoreArray[i]
        val id = idArray[i]

        //최고 최저의 값이 null이 아닐때만 갱신
        if (score != null) {
            if (highestScore == null || score > highestScore) {
                highestScore = score
                highestId = id
            }
            if (lowestScore == null || score < lowestScore) {
                lowestScore = score
                lowestId = id
            }
        }
    }

    // 최종 출력 null은 unknown
    println("Avg. score: $avgScore")
    println("Highest score -> ID: ${highestId ?: "Unknown"} Score: ${highestScore ?: "Unknown"}")
    println("Lowest score -> ID: ${lowestId ?: "Unknown"} Score: ${lowestScore ?: "Unknown"}")
}