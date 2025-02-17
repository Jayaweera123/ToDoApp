const ToDoCard = ({ task, onDelete }) => {
  return (
    <div className="bg-gray-300 p-4 rounded-lg flex justify-between items-center shadow-md">
      <div>
        <h3 className="font-bold text-black">{task.title}</h3>
        <p className="text-black">{task.description}</p>
      </div>
      <button
        onClick={onDelete}
        className="border border-black px-3 py-1 rounded-md hover:bg-gray-400 transition duration-200"
      >
        Done
      </button>
    </div>
  );
};

export default ToDoCard;
