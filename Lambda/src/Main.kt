import kotlin.math.sqrt  //수식 사용

typealias Point = List<Int>
typealias PointList = List<Point>

val pt: (Int, Int) -> List<Int> = { a, b -> listOf(a, b) }
val default_func = { points: PointList -> points }

// Task 1: Define `process` as a named function
fun process(points: PointList, processor: (PointList) -> Any = default_func) {
    val result = processor(points)
    println(result)
}

// Task 2: Define `filterLeft` as a named function
fun filterLeft(points: PointList): PointList {
    return points.filter { it[0] < 0 } //it = n[0] -> n
}

// Task 3: Define `norm` as a lambda function
val norm: (Point) -> Double = { point -> sqrt((point[0] * point[0] + point[1] * point[1]).toDouble()) }

// Task 4: Define `normAll` as a lambda function
val normAll: (PointList) -> List<Double> = { points -> points.map(norm) }

// Task 5: Define `normLessThanTwo` as a lambda function
val normLessThanTwo: (PointList) -> PointList = { points -> points.filter { norm(it) <= 2 } }

// Task 6: Define `flipX` as a named function
fun flipX(points: PointList): PointList {
    return points.map { pt(-it[0], it[1]) }
}

fun main() {
    val points = listOf(pt(1, 2), pt(-2, 3), pt(-1, 0), pt(2, 1))

    print("original points: \t")
    process(points)

    print("left points: \t")
    process(points, ::filterLeft) // using filterLeft function

    print("norms: \t")
    process(points) { normAll(it) }// using normAll lambda normAll is list(double)

    print("norm<2: \t")
    process(points, normLessThanTwo) // using normLessThanTwo lambda

    print("flip_x: \t")
    process(points, ::flipX) // using flipX function
}