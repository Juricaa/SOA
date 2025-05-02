
from django.contrib import admin
from django.urls import include, path
from GererAppartement.view import index

urlpatterns = [
    path('admin/', admin.site.urls),
    path('employee/', include("employee.urls"))
]
