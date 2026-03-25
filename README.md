# AI-Agent

基于 **Spring Boot + Maven + Spring AI(OpenAI)** 的 AI Agent 初始骨架。

## 当前接入情况
- ✅ 已接入：OpenAI（通过 Spring AI `spring-ai-starter-model-openai`）
- ❌ 未接入：Azure OpenAI / Ollama / Claude / Gemini 等其他模型 API（可后续扩展）

## 技术栈
- Java 17
- Spring Boot 3.3.x
- Spring AI 1.0.x
- Spring Web / Validation / Actuator

## 配置
环境变量：
- `OPENAI_API_KEY`：OpenAI API Key（生产/联调时必填）
- `OPENAI_MODEL`：模型名，默认 `gpt-4o-mini`
- `CHAT_MOCK`：是否启用 mock 模式，默认 `true`

> 默认 `CHAT_MOCK=true`，可先本地联调接口，不依赖外部 API。

## 快速启动
```bash
mvn spring-boot:run
```

## API
### 健康检查
- `GET /api/v1/chat/ping`

### 聊天接口
- `POST /api/v1/chat`
- Request:
```json
{
  "message": "你好"
}
```
- Response (mock):
```json
{
  "provider": "mock",
  "reply": "[mock] 收到消息: 你好"
}
```
- Response (OpenAI):
```json
{
  "provider": "openai",
  "reply": "...模型回复..."
}
```
