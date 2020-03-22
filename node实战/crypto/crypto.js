const crypto = require("crypto");

module.exports = function(password,key = "this is tao page"){
    const hash = crypto.createHmac("sha256",key);
    hash.update(password);
    return hash.digest("hex");
}

