import { useState, useContext } from "react";
import { TaskContext } from "../context/TaskContext";

const TaskForm = () => {
  const { handleAddTask } = useContext(TaskContext);
  const [task, setTask] = useState({ title: "", description: "" });

  const handleSubmit = (e) => {
    e.preventDefault();
    if (task.title.trim() === "" || task.description.trim() === "") return;
    handleAddTask(task);
    setTask({ title: "", description: "" });
  };

  return (
    <form className="p-4 bg-white shadow-md rounded" onSubmit={handleSubmit}>
      <h2 className="text-xl font-bold mb-2">Add a Task</h2>
      <input
        type="text"
        placeholder="Title"
        className="w-full p-2 mb-2 border rounded"
        value={task.title}
        onChange={(e) => setTask({ ...task, title: e.target.value })}
      />
      <textarea
        placeholder="Description"
        className="w-full p-2 mb-2 border rounded"
        value={task.description}
        onChange={(e) => setTask({ ...task, description: e.target.value })}
      ></textarea>
      <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded">
        Add
      </button>
    </form>
  );
};

export default TaskForm;