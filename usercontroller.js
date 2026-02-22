async function createUser(request, reply) {
    const { name, email } = request.body
    if (!name || !email) {
      return { error: "Le nom et l'email sont requis" }
    }
    const [result] = await request.server.mysql.query(
      "INSERT INTO user (name, email) VALUES (?, ?)",
      [name, email]
    )
    console.log("✅ CREATE - ID inséré:", result.insertId)
    return { 
      success: true,
      id: result.insertId, 
      name, 
      email }
}
async function getUsers(request, reply) {
    const [rows] = await request.server.mysql.query("SELECT * FROM user")
    return rows

}
async function deleteUser(request, reply) {
    const { id } = request.params
    if (!id) {
      reply.code(400)
      return { error: "ID manquant" }
    }
    const [result] = await request.server.mysql.query(
      "DELETE FROM user WHERE id = ?",
      [id]
    )
    if (result.affectedRows === 0) {
      reply.code(404)
      return { error: "Utilisateur non trouvé" }
    }

    console.log("✅ DELETE - Suppression réussie")
    return { 
      success: true,
      message: "User deleted",
      id: parseInt(id),
      affectedRows: result.affectedRows 
    }
}
module.exports = {
  createUser,
  getUsers,
  deleteUser
}