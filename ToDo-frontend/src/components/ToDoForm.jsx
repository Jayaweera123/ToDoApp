import { useState } from "react";

const ToDoForm = ({ addTask }) => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (title.trim() === "" || description.trim() === "") return;
    addTask({ title, description });
    setTitle("");
    setDescription("");
  };

  return (
    <div className="bg-white p-6 shadow-lg rounded-lg w-full">
      <h2 className="text-xl font-bold mb-4 text-black">Add a Task</h2>
      <form onSubmit={handleSubmit}>
        <label className="block text-black font-semibold mb-1">Task</label>
        <input
          type="text"
          placeholder="Add your task"
          className="w-full p-2 border rounded-md mb-4 text-black"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <label className="block text-black font-semibold mb-1">Description</label>
        <textarea
          placeholder="Description"
          className="w-full p-2 border rounded-md mb-4 h-24 text-black"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        ></textarea>
        <button
          type="submit"
          className="w-full bg-blue-600 text-white py-2 rounded-md hover:bg-blue-700 transition duration-200"
        >
          Add Task
        </button>
      </form>
    </div>
  );
};

export default ToDoForm;
