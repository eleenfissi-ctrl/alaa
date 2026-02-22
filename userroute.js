const userController = require('../controller/usercontroller')

async function userRoutes(fastify, options) {
  fastify.post('/users', userController.createUser)
  fastify.get('/users', userController.getUsers)
  fastify.delete('/users/:id', userController.deleteUser)
  }

module.exports = userRoutes