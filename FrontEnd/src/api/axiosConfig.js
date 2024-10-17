import axios from "axios";

export default axios.create({
  // create axios object so all its methods can be accessed
  baseURL: "https://7b27-62-248-142-247.ngrok-free.app",
  headers: { "ngrok-skip-browser-warning": "*" }, //allows http requests be cross-origin resource sharing (cors)
});
