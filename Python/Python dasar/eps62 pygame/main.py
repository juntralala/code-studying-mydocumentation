import pygame
# Struktur
# init
# user input, dat basae input
# update asset
# render ke display

# init
pygame.init()

# membuat display surface object
windowPanjang = 700
windowTinggi = 500
window = pygame.display.set_mode((windowPanjang,windowTinggi))

# Object game 
x = 350
y = 250
lebar = 20
panjang = 20

# movement speed
speed = 0.1

isRun = True
while isRun :
    # user input, databse input
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            isRun = False
    
    # ambil semua keyboard press
    key = pygame.key.get_pressed()

    # ambil kekkiri
    if key[pygame.K_LEFT ] and x>0:
        x -= speed
    if key[pygame.K_RIGHT] and x<windowPanjang-lebar :
        x += speed
    if key[pygame.K_UP] and y >0 :
        y -= speed
    if key[pygame.K_DOWN] and y<windowTinggi-panjang :
        y += speed
    
    # update Asset
    window.fill((255,255,255))
    pygame.draw.rect(window,(80,90,255),(x,y,lebar,panjang))
    # render ke display
    pygame.display.update()

pygame.quit()



