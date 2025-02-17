const ToDoCard = ({ task, onDelete }) => {
  return (
    <div className="bg-gray-300 p-4 rounded-lg flex flex-col sm:flex-row justify-between items-center shadow-md w-full
        transition-transform transform hover:scale-105 hover:shadow-lg cursor-pointer">
      <div className="text-center sm:text-left">
        <h3 className="font-bold text-black">{task.title}</h3>
        <p className="text-black">{task.description}</p>
      </div>
      <button
        onClick={onDelete}
        className="border border-black px-3 py-1 rounded-md hover:bg-gray-400 transition duration-200 mt-2 sm:mt-0"
      >
        Done
      </button>
    </div>
  );
};

export default ToDoCard;
