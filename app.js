const fastify = require('fastify')({ logger: true })
const path = require('path')

// Enregistrer le plugin static
fastify.register(require('@fastify/static'), {
  root: path.join(__dirname, 'public'),
  prefix: '/public/' // optionnel
})

// Enregistrer CORS si nécessaire
fastify.register(require('@fastify/cors'), {
  origin: true
})

// Enregistrer le plugin DB
fastify.register(require('./plugins/db'))

// Enregistrer les routes
fastify.register(require('./routes/userroute'), { prefix: '/api' })

// Route de test
fastify.get('/', async (request, reply) => {
  return { 
    message: 'Fastify API is running!',
    status: 'OK',
    timestamp: new Date().toISOString()
  }
})

module.exports = fastify
