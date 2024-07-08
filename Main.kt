data class Task(
    val title: String,
    val description: String,
    val dueDate: String,
    val priority: Int
)

fun main() {
    val mutListTasks = mutableListOf<Task>()

             println("Task Manager")
      println("1. View tasks")
    println("2. Add a task")
    println("3. Complete a task")
    println("4. Exit")

    var userChoice: String?
    do {
        print("Enter your choice: ")
        userChoice = readLine()

        when (userChoice) {
            "1" -> viewTasks(mutListTasks)
            "2" -> addTask(mutListTasks)
            "3" -> completeTask(mutListTasks)
            "4" -> println("Exiting Task Manager. Goodbye!")
            else -> println("Invalid choice. Please enter a number from 1 to 4.")
        }
    } while (userChoice != "4")
}

fun viewTasks(tasks: List<Task>) {
    println("Tasks:")
    tasks.forEachIndexed { index, task ->
        println("${index + 1}. ${task.title} - Due: ${task.dueDate}, Priority: ${task.priority}")
    }
}

fun addTask(mutListTasks: MutableList<Task>) {
    println("Enter task details:")
    print("Title: ")
    val title = readLine() ?: ""
    print("Description: ")
    val description = readLine() ?: ""
    print("Due Date (YYYY-MM-DD): ")
    val dueDate = readLine() ?: ""
    print("Priority (1-5): ")
    val priority = readLine()?.toIntOrNull() ?: 1

    val newTask = Task(title, description, dueDate, priority)
    mutListTasks.add(newTask)
    println("Task added.")
}

fun completeTask(mutListTasks: MutableList<Task>) {
    println("Enter the title of the task you want to complete: ")
    val title = readLine() ?: ""

    val initialSize = mutListTasks.size
    mutListTasks.removeAll { it.title == title }

    if (mutListTasks.size < initialSize) {
        println("Task '$title' completed.")
    } else {
        println("Task '$title' not found.")
    }
}
