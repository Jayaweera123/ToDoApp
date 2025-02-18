import { useState, useRef } from "react";

const ToDoForm = ({ addTask, showSuccessMessage }) => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const descriptionRef = useRef(null); // Reference for the description field

  const handleSubmit = (e) => {
    e.preventDefault();
    if (title.trim() === "" || description.trim() === "") return;

    addTask({ title, description });
    setTitle("");
    setDescription("");

    // Show success popup
    showSuccessMessage();
  };

  // Move focus to the description field on Enter key in title input
  const handleKeyDownTitle = (e) => {
    if (e.key === "Enter") {
      e.preventDefault();
      descriptionRef.current.focus();
    }
  };

  // Submit form when Enter is pressed in description field
  const handleKeyDownDescription = (e) => {
    if (e.key === "Enter" && !e.shiftKey) {
      e.preventDefault();
      handleSubmit(e);
    }
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
          onKeyDown={handleKeyDownTitle} // Listen for Enter key
        />
        <label className="block text-black font-semibold mb-1">Description</label>
        <textarea
          ref={descriptionRef}
          placeholder="Description"
          className="w-full p-2 border rounded-md mb-4 h-24 text-black"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          onKeyDown={handleKeyDownDescription} // Listen for Enter key
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
